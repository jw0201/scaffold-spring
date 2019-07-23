package com.jiwon.app.repository;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 * com.jiwon.app.repository
 * ApplicationRepository.java
 * </pre>
 *
 * @author 김종민(jw0201@gmail.com)
 * @date   2016. 9. 2.
 * @version
 */
public interface ApplicationRepository {
	public abstract List<Map<String, Object>> select(Map<String, Object> map);
}