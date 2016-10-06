package com.xiaoyue26.www.service;

import com.xiaoyue26.www.entity.Check;
import com.xiaoyue26.www.tool.EncoderHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;

/**
 * Created by xiaoyue26 on 10/6/16.
 */
@Service
public class TokenService {
    
    @Transactional
    public String validate(String wxToken, Check tokenModel) {
        String signature = tokenModel.getSignature();
        Long timestamp = tokenModel.getTimestamp();
        Long nonce = tokenModel.getNonce();
        String echostr = tokenModel.getEchostr();
        if (signature != null && timestamp != null & nonce != null) {
            String[] str = {wxToken, timestamp + "", nonce + ""};
            Arrays.sort(str);
            String bigStr = str[0] + str[1] + str[2];
            String digest = EncoderHandler.encode("SHA1", bigStr).toLowerCase();
            if (digest.equals(signature)) {
                return echostr;
            }
        }
        return "error";
    }
}
