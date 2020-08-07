package com.wenxr.iot.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 类描述：XML 工具类
 * 
 * @author wxr
 * @version 1.0 CreateDate: 2016-5-24
 * 
 * @history：
 * @updateDate @updatePerson @declare
 * 
 */
public class XmlUtil {

	/**
	 * 方法描述：将map 转换成xml 格式输出
	 * 
	 * @param map
	 * @return
	 */
	public static String createrXmlByMap(Map<String, String> map) {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("root");
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			root.addAttribute(key, map.get(key));
		}
		return document.asXML();
	}

	/**
	 * 方法描述：将指定节点转换成MAP 对象 （该节点下只有一层节点）
	 * 
	 * @param documentXml
	 * @param nodeString
	 *            指定转换成MAP对象的NODE 节点
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> xmlToMapByNode(String documentXml, String nodeString) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Document d = DocumentHelper.parseText(documentXml);
			Element e = (Element) d.selectSingleNode("//" + nodeString);
			Iterator<?> it = e.elementIterator();
			while (it.hasNext()) {
				Element ee = (Element) it.next();
				map.put(ee.getQualifiedName(), ee.getText());
			}
			return map;
		} catch (Exception e) {
			throw new RuntimeException("XML转MAP异常：" + e.getMessage());
		}
	}

}
