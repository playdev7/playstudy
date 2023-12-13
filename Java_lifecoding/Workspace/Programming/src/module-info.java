/**
 * 
 */
/**
 * @author Volt
 *
 */

// ColorDimmingLights.java 에서 awt 객체 import 불가로 모듈 의존성 기술.
// java.se 모듈 포함 시 java.desktop의 java.awt 포함 됨.
module org.opentutorials.iot {
	requires java.se;
}

// java.base 모듈에는 java.lang / java.math / java.util / java.io / java.net / java.time 등 탑재
// java.se 모듈에는 java.base 모듈을 기본으로 java.desktop ( java.awt, java.swing ) / java.sql ( java.sql, javax.sql ) 등 탑재.