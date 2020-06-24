package com.springcloud.learn.jpalearn.rest;

import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CodeUtil {
	public static String encoding(String encoding) {
		try {
			if(!StringUtils.isEmpty(encoding))
				encoding = URLEncoder.encode(encoding, "utf-8");
		} catch (Exception el) {
			el.printStackTrace();
		}
		return encoding;
	}

	/**
	 * 解码
	 * 
	 * @param encoding
	 * @return
	 */
	public static String decoding(String encoding) {
		try {
			if(!StringUtils.isEmpty(encoding))
				encoding = URLDecoder.decode(encoding.trim(), "utf-8");
			//encoding = new String(encoding.getBytes("ISO-8859-1"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return encoding;

	}
	
	/**
	 * 页面encodeURI解码
	 * 
	 * @param encoding
	 * @return
	 */
	public static String decodeURI(String encoding) {
		try {
			if(!StringUtils.isEmpty(encoding)){
				encoding = new String(encoding.getBytes("ISO-8859-1"), "UTF-8");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return encoding;

	}
	public static String checkCRCNew(String source) throws UnsupportedEncodingException {
		byte[] byteArray = source.getBytes("utf-8");
		return checkCRC(byteArray);
	}

	public static String checkCRC(byte[] source) {
		int crc_reg = 0XFFFF;
		for (int i = 0; i < source.length; i++) {
			crc_reg = crc_reg >> 8 ^ source[i];
			for (int j = 0; j < 8; j++) {
				int check = crc_reg & 0x1;
				crc_reg >>= 1;
				if (check == 1) {
					crc_reg ^= 0xA001;
				}
			}
		}
		return IntegerToHexString(crc_reg).toUpperCase();
	}
	public static String IntegerToHexString(int value) {
		if (value > 65535) {
			return "FFFF";
		}
		String asStr = Integer.toHexString((0xFFFF & value)).toUpperCase();
		int len = asStr.length();
		if (len < 4) {
			asStr = StringUtils.leftPad(asStr, 4, '0');
		}
		return asStr;
	}
	
	public static String checkCRCStr(String puchMsg){
		return StringUtils.leftPad(Integer.toHexString(checkCRC(puchMsg)).toUpperCase(),4,'0');
	}
	
	public static int checkCRC(String puchMsg) {
		int uchCRC = 0xFFFF;
        int usDataLen = puchMsg.length();
        int i = 0;
        int cursor = 0;
        while (usDataLen > 0) {
            uchCRC =  (uchCRC ^ (puchMsg.charAt(cursor++)<< 8));
            for (i = 0; i < 8; i++) {
                if (uchCRC % 2 != 0) {
                    uchCRC >>= 1;
                    uchCRC = (uchCRC ^ (0xA001));
                }
                else
                    uchCRC >>= 1;
            }
            usDataLen--;
        }
        return uchCRC;
    }
}
