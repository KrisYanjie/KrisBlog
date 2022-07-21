package com.yj.login.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.yj.login.constant.CaptchaConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class KaptchaController {
    @Autowired
    private DefaultKaptcha defaultKaptcha;
    @Autowired
    private RedisTemplate redisTemplate;
    @GetMapping("kaptcha")
    public String getKaptcha(HttpServletRequest request) throws IOException {
        // 以当前毫秒数生成随机key，注意高并发情况下，这不是一种好的选择
        String key = CaptchaConstants.CAPTCHA_KEY_PREFIX;
        String text = defaultKaptcha.createText();
        request.getServletContext().setAttribute("code",text);
        // 将生成的验证码保存到redis中，并设置有效期为30分种
        redisTemplate.opsForValue().set(key,text, CaptchaConstants.CAPTCHA_EXPIRATION*60, TimeUnit.SECONDS);
        BufferedImage image = defaultKaptcha.createImage(text);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image,"png",outputStream);
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(outputStream.toByteArray());
        encode= "data:image/png;base64,"+encode;
        return encode;
    }


}
