/**
 * 모든 모형의 공통적인 속성과 기능을 정의한 추상클래스
 * 
 * @author 서지원
 *
 */
public abstract class Shape {
	protected double x, y; // 확장하더라도 사용가능

	// 추상 메서드
	// 서브클래스가 반드시 구현 (재정의) 해야 할 수직적 규약
	public abstract void draw();

	public abstract double getLength();

	public abstract double getArea();


	}

