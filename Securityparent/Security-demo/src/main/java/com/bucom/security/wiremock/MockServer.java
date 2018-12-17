package com.bucom.security.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;

public class MockServer {

  public static void main(String[] args) {
    //
      WireMock.configureFor(8080);
      WireMock.removeAllMappings();
      String body="{\"id\":1}";
      WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/order/1")).willReturn(WireMock.aResponse().withBody(body).withStatus(200)));
  }
}
