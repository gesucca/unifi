package it.unifi.rc.httpserver.m5951907.handler;

import it.unifi.rc.httpserver.HTTPReply;
import it.unifi.rc.httpserver.HTTPRequest;
import it.unifi.rc.httpserver.m5951907.MyHTTPProtocolException;
import it.unifi.rc.httpserver.m5951907.message.MyHTTPReply;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class MyHTTPHandler1_0 extends AbstractHTTPHandler {

	public MyHTTPHandler1_0(File root) {
		super(root);
	}

	@Override
	protected List<String> getProtocolSupportedMethods() {
		return Arrays.asList("GET", "HEAD", "POST");
	}

	@Override
	protected String getProtocolVersion() {
		return "HTTP/1.0";
	}

	@Override
	protected HTTPReply handlingImplementation(HTTPRequest req) throws MyHTTPProtocolException {
		switch (req.getMethod()) {
			case "GET":
				return implementGET(req.getPath());
			case "HEAD":
				return implementHEAD(req.getPath());
			case "POST":
				return implementPOST(req.getPath(), req.getEntityBody());
			default:
				throw new MyHTTPProtocolException(404, "Not Found", "REQUESTED RESOURCE WAS NOT FOUND: " + req.getPath());
		}
	}

	private HTTPReply implementPOST(String path, String body) throws MyHTTPProtocolException {
		return null;
	}

	private HTTPReply implementHEAD(String path) throws MyHTTPProtocolException {
		return null;
	}

	private HTTPReply implementGET(String url) throws MyHTTPProtocolException {
		return new MyHTTPReply("HTTP/1.0", super.fetchResource(url));
	}
}