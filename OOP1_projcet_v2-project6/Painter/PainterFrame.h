#pragma once
#include "Windows.h"
#include <string>
#include <list>
#include "Misc.h"
#include "Figure.h"
#include "MyButton.h"
#include "frame.h"
#include "MyLabel.h"

class MyButton;
class PainterFrame : public Frame{
protected:

	// ������ ���� �ʿ��� ����
	MyPoint start_;
	MyPoint end_;

	// ����, �׷� �ڽ��� �����ϴ� ����Ʈ
	std::list<Group*> myGroupList;
	std::list<MyButton*> myButtonList;
	std::list<MyLabel*> myLabelList;

	// ���� Ÿ�� ���� ����
	static const int NONE = 1;
	static const int RECTANGLE = 2;
	static const int CIRCLE = 3;

	// ��ư Ÿ��Ʋ ��� ���� ���� ���
	static const int RECT_CORRECT_X = 32;
	static const int RECT_CORRECT_Y = 8;
	static const int CIRCLE_CORRECT_X = 18;
	static const int CIRCLE_CORRECT_Y = 6;

	static const int APPLE_CORRECT_X = 18;
	static const int APPLE_CORRECT_Y = 8;
	static const int BANANA_CORRECT_X = 16;
	static const int BANANA_CORRECT_Y = 6;


	static const int APPLE = 4;
	static const int BANANA = 5;

public:
	PainterFrame();
	PainterFrame(std::wstring, int, int);
	void eventHandler(MyEvent e) override;
	void repaint() override;
	void init() override;

	void setShape(int type);
	void createGroup();
	Group* findClickedElement(MyPoint pos);
	MyButton * findClickedButton(MyPoint pos);
	
};

