package demo.service;

import demo.domain.PaymentInfo;
import demo.domain.RequestInfo;
import demo.domain.ResponseInfo;
import sun.misc.Request;

import java.io.IOException;
import java.util.List;

/**
 * Created by vagrant on 9/2/17.
 */
public interface ItemsPaymentService {
    public List<PaymentInfo> payItems(RequestInfo requestInfo) throws IOException;
    public void updateBankInfo(RequestInfo requestInfo);
}
