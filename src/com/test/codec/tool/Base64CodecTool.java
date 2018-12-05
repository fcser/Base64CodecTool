package com.test.codec.tool;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64CodecTool {

	private final Base64.Decoder decoder = Base64.getDecoder();
	private final Base64.Encoder encoder = Base64.getEncoder();
	private final String ENCODEFAIL="编码失败";
	private final String DECODEFAIL="解码失败";
	/**
	 * 将字符串转化为base64，编码
	 * @param text
	 * @return
	 */
	public String encodeString(String text) {
		try {
			byte[] textByte = text.getBytes("UTF-8");
			return encoder.encodeToString(textByte);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ENCODEFAIL;
		}
	}
	/**
	 * 将base64编码格式转化为字符串
	 * @param code
	 * @return
	 */
	public String decodeString(String code) {
		try {
			return new String(decoder.decode(code), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return DECODEFAIL;
		}
	}
	
	/**
	 * 将base64编码字符串转换为图片
	 * @param imgStr图片的base64编码
	 * @param path图片保存路径
	 * @return
	 */
    public boolean generateImage(String imgStr, String path) {
        if(imgStr == null){
            return false;
        }
        
        try{
            //解密
            byte[] b = decoder.decode(imgStr);
            //处理数据
            for (int i = 0;i<b.length;++i){
                if(b[i]<0){
                    b[i]+=256;
                }
            }
            OutputStream out = new FileOutputStream(path);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * @Description: 根据图片地址转换为base64编码字符串
     * @Author:
     * @CreateTime:
     * @return
     */
    public String getImageStr(String imgFile) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
            //加密
            return encoder.encodeToString(data);
        } catch (IOException e) {
            e.printStackTrace();
            return ENCODEFAIL;
        }
    }
}
