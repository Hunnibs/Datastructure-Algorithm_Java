# [Gold V] 괄호 제거 - 2800 

[문제 링크](https://www.acmicpc.net/problem/2800) 

### 성능 요약

메모리: 21564 KB, 시간: 232 ms

### 분류

브루트포스 알고리즘, 자료 구조, 스택, 문자열

### 제출 일자

2024년 2월 5일 20:35:26

### 문제 설명

<p>Mirko was bored at his chemistry class, so he played Bomb Switcher on his cell phone. Unfortunately, he was spotted and was given a ridiculously heavy assignment for homework. For a given valid math expression with brackets, he must find all different expressions that can be obtained by removing valid pairs of brackets from the original expression. Two expressions are different if there is a character at which they differ.</p>

<p>For example, given (2+(2*2)+2), one can get (2+2*2+2), 2+(2*2)+2, and 2+2*2+2. (2+2*2)+2 and 2+(2*2+2) can‟t be reached, since we would have to remove pairs of brackets that are not valid. More than one pairs of brackets can surround the same part of the expression.</p>

### 입력 

 <p>The first and only line of input contains one valid mathematical expression composed of nonnegative integers, basic arithmetic operations denoted with characters "+", "*", "-" and "/", and brackets "(" and ")".</p>

<p>Given expression won"t have more than 200 characters, and will have at least one, and no more than 10 pairs of brackets. Each expression is guaranteed to have at least one pair of brackets.</p>

### 출력 

 <p>Output all different expressions that can be obtained by removing valid pairs of brackets, sorted lexicographically.</p>

