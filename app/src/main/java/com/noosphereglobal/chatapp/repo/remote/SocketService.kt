package com.noosphereglobal.chatapp.repo.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.noosphereglobal.chatapp.util.SingleLiveData
import com.noosphereglobal.chatapp.util.d
import okhttp3.*
import javax.inject.Inject

class SocketService @Inject constructor(private val client: OkHttpClient) : ISocketService {

    private var ws: WebSocket? = null
    private var request: Request? = null
    private var openChatErrorListener: SingleLiveData<String?>? = null
    private var sendMessageErrorListener: SingleLiveData<String?>? = null
    private val message: LiveData<String?> = MutableLiveData()
    private var isOpen = false
    private var currentUrl = ""
    private var url = ""

    private val socketListener = object : WebSocketListener() {
        override fun onOpen(webSocket: WebSocket, response: Response) {
            d("onOpen")
            isOpen = true
            openChatErrorListener?.postValue(null)
        }

        override fun onMessage(webSocket: WebSocket, text: String) {
            d("onMessage")
            (message as MutableLiveData).postValue(text)
        }

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
            d("onFailure")
            openChatErrorListener?.postValue(t.message)
            sendMessageErrorListener?.postValue(t.message)
        }

        override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
            ws?.close(NORMAL_CLOSURE_STATUS, "ok")
            ws?.cancel()
        }

        override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
            d("onClosed")
            isOpen = false
            currentUrl = ""
        }
    }

    override fun getMessage(): LiveData<String?> {
        return message
    }

    override fun openChat(url: String, setErrorListener: (error: String?) -> Unit) {
        this.url = url
        openChatErrorListener = SingleLiveData()

        if ((isOpen && currentUrl != url) || (!isOpen && currentUrl != url) || (!isOpen && currentUrl == url)) {
            currentUrl = url

            openChatErrorListener?.observeForever {
                setErrorListener(it)
            }
            request = Request.Builder().url(url).build()
            ws = client.newWebSocket(request!!, socketListener)
            client.dispatcher.executorService.shutdown()
        } else {
            setErrorListener(null)
        }
    }

    override fun sendMessage(json: String, setErrorListener: (error: String?) -> Unit) {
        sendMessageErrorListener = SingleLiveData()
        ws?.send(json)
        sendMessageErrorListener?.observeForever { setErrorListener(it) }
    }

    override fun closeChat() {
        if (isOpen) {
            ws?.close(NORMAL_CLOSURE_STATUS, "ok")
        }
    }

    companion object {
        private const val NORMAL_CLOSURE_STATUS: Int = 1000
    }
}