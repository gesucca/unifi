package it.unifi.rc.httpserver.m5951907;

import it.unifi.rc.httpserver.*;
import it.unifi.rc.httpserver.m5951907.handler.MyHTTPHandler1_0;
import it.unifi.rc.httpserver.m5951907.handler.MyHTTPHandler1_1;
import it.unifi.rc.httpserver.m5951907.server.MyHTTPServer;
import it.unifi.rc.httpserver.m5951907.stream.MyHTTPInputStream;
import it.unifi.rc.httpserver.m5951907.stream.MyHTTPOutputStream;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;

@SuppressWarnings("unused")
public class MyHTTPFactory implements HTTPFactory {

	@Override
	public HTTPInputStream getHTTPInputStream(InputStream is) {
		return new MyHTTPInputStream(is);
	}

	@Override
	public HTTPOutputStream getHTTPOutputStream(OutputStream os) {
		return new MyHTTPOutputStream(os);
	}

	@Override
	public HTTPServer getHTTPServer(int port, int backlog, InetAddress address, HTTPHandler... handlers) {
		HTTPServer server = new MyHTTPServer(port, backlog, address);
		for (HTTPHandler h : handlers)
			server.addHandler(h);
		return server;
	}

	@Override
	public HTTPHandler getFileSystemHandler1_0(File root) {
		return new MyHTTPHandler1_0(root);
	}

	@Override
	public HTTPHandler getFileSystemHandler1_0(String host, File root) {
		return new MyHTTPHandler1_0(host, root);
	}

	@Override
	public HTTPHandler getFileSystemHandler1_1(File root) {
		return new MyHTTPHandler1_1(root);
	}

	@Override
	public HTTPHandler getFileSystemHandler1_1(String host, File root) {
		return new MyHTTPHandler1_1(host, root);
	}

	@Override
	public HTTPHandler getProxyHandler() {
		//TODO
		return null;
	}
}
