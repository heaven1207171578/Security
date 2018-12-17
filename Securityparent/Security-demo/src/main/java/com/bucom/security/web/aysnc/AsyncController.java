package com.bucom.security.web.aysnc;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

@RestController
public class AsyncController {
  Logger log = LoggerFactory.getLogger(AsyncController.class);

  @Autowired private QueueMoni mockQueue;

  @Autowired private DeferredResultHolder deferredResultHolder;

  @RequestMapping("/order")
  public Callable<String> order() throws InterruptedException {
    log.info("主线程开始");
    Callable<String> result =
        new Callable<String>() {
          @Override
          public String call() throws Exception {
            log.info("儿子线程开始");
            Thread.sleep(1000);
            log.info("儿子线程结束");
            return "success";
          }
        };
    log.info("主线程fanhui ");
    return result;
  }

  @RequestMapping("/orders")
  public DeferredResult<String> orderDeferred() throws Exception {
    log.info("主线程开始");

    String orderNumber = RandomStringUtils.randomNumeric(8);
    mockQueue.setPlaceOrder(orderNumber);

    DeferredResult<String> result = new DeferredResult<>();
    deferredResultHolder.getMap().put(orderNumber, result);

    return result;
  }

}