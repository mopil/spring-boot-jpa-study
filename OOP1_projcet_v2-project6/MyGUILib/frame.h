#pragma once
#include "Windows.h"
#include <string>
#include "Misc.h"

LRESULT CALLBACK WndProc(HWND hwnd, UINT msg, WPARAM wParam, LPARAM lParam);
class Frame {
protected:
	// Window ���α׷����� ���� �⺻ �������̴�. �ǵ帮�� �ʴ´�.
	HINSTANCE hInst_;
	HWND hWnd_;
	HDC hDC_;    // �� ������ �־�� �׸��� �׸� �� �ִ�.

public:
	Frame();
	Frame(std::wstring, int, int);
	virtual void run();
	void invalidate();

	virtual void eventHandler(MyEvent e) = 0;
	virtual void repaint() = 0;
	virtual void init() = 0;

};

