package dispa.context;

import java.net.HttpCookie;
import java.util.ArrayList;

public class ConnectionContext extends VirtualIdentity {

	private ArrayList<HttpCookie> cookies = new ArrayList<HttpCookie>();
	// static because all contexts use the same user-agent
	private static String userAgent = null;
	
	
	public ConnectionContext(int newId) {
		super(newId);
	}

}
