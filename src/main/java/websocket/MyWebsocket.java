package websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.apache.catalina.websocket.WsOutbound;

@WebServlet("/chat")
public class MyWebsocket extends WebSocketServlet {
	private final Map<Integer, WsOutbound> map = new HashMap<>();

	protected StreamInbound createWebSocketInbound(String arg0, HttpServletRequest arg1) {

		return new ChatMessageInbound();

	}

	class ChatMessageInbound extends MessageInbound {

		@Override
		public void onOpen(WsOutbound outbound) {
			System.out.println("已连接。。。");
			System.out.println(map.size());
			map.put(outbound.hashCode(), outbound);
			super.onOpen(outbound);
		}

		@Override
		protected void onClose(int status) {
			System.out.println("已断开连接");
			map.remove(map.get(getWsOutbound()));
			System.out.println(map.size());
			super.onClose(status);
		}

		@Override
		protected void onBinaryMessage(ByteBuffer arg0) throws IOException {
			// TODO Auto-generated method stub

		}

		@Override
		// 群发信息
		protected void onTextMessage(CharBuffer bufferd) throws IOException {

			String msg = bufferd.toString();
			Date date = new Date();
			System.out.println(msg);
			SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");
			s.format(date);
			broadcast(msg);
		}

		public void broadcast(String msg) {
			Set<Integer> set = map.keySet();
			for (Integer s : set) {
				WsOutbound outbound = map.get(s);
				CharBuffer buffer = CharBuffer.wrap(msg);
				try {
					outbound.writeTextMessage(buffer);
					outbound.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

}
