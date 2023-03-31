// awt 객체 import 시 오류 발생.
// The package java.awt is not accessible
// Java 9 버전부터는 모듈 기술 필요.
// module-info.java 파일에서 java.se 모듈 의존성 기술.
// 또는 JavaSE-1.8  -Java 8 이하 버전으로 변경.

package org.opentutorials.iot;

import java.awt.Color;

public class ColorDimmingLights extends DimmingLights {

	double _bright = 0;
	Color _color;
	
	public ColorDimmingLights(String id) {
		super(id);
		this._color = Color.white;
	}
	
	public void setColor(Color color) {
		this._color = color;
		System.out.println(this._id + " -> ColorDimmingLights color : "+color);
	}

}
