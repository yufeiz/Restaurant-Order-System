package demo.service;

import demo.domain.ItemInfo;
import demo.domain.RequestInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by vagrant on 8/31/17.
 */
public interface ItemOrderService {

    ArrayList<ItemInfo> saveOrder(List<RequestInfo> requestInfo);
}
