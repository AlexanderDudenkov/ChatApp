package com.noosphereglobal.chatapp.repo.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.noosphereglobal.chatapp.util.d
import okhttp3.*
import javax.inject.Inject

class SocketService @Inject constructor(private val client: OkHttpClient) : ISocketService {

    private var ws: WebSocket? = null
    private var request: Request? = null
    private var openChatErrorListener: ((error: String?) -> Unit)? = null
    private var sendMessageErrorListener: ((error: String?) -> Unit)? = null
    private val message: LiveData<String?> = MutableLiveData()
    private var isOpen = false
    private var currentUrl = ""
    private var url = ""

    private val socketListener = object : WebSocketListener() {
        override fun onOpen(webSocket: WebSocket, response: Response) {
            d("onOpen")
            isOpen = true
            openChatErrorListener?.invoke(null)
        }

        override fun onMessage(webSocket: WebSocket, text: String) {
            d("onMessage")
            (message as MutableLiveData).postValue(text)
        }

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
            d("onFailure")
            openChatErrorListener?.invoke(t.message)
            sendMessageErrorListener?.invoke(t.message)
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

        if ((isOpen && currentUrl != url) || (!isOpen && currentUrl != url) || (!isOpen && currentUrl == url)) {
            currentUrl = url

            openChatErrorListener = setErrorListener
            request = Request.Builder().url(url).build()
            ws = client.newWebSocket(request!!, socketListener)
            client.dispatcher.executorService.shutdown()
        } else {
            openChatErrorListener?.invoke(null)
        }
    }

    override fun sendMessage(json: String, setErrorListener: (error: String?) -> Unit) {
        ws?.send(json)
        sendMessageErrorListener = setErrorListener
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