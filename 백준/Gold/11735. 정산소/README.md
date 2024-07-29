# [Gold IV] 정산소 - 11735 

[문제 링크](https://www.acmicpc.net/problem/11735) 

### 성능 요약

메모리: 63752 KB, 시간: 432 ms

### 분류

수학

### 제출 일자

2024년 7월 29일 11:01:57

### 문제 설명

<p>Garrison and Anderson are working in a company named “Adjustment Office”. In competing companies workers change the reality, in this company they try to predict the future.</p>

<p>They are given a big square board n × n. Initially in each cell (x, y) of this board the value of x + y is written (1 ≤ x, y ≤ n). They know that in the future there will be two types of queries on the board:</p>

<ul>
	<li>“<code>R</code> r” — sum up all values in row r, print the result and set all values in row r to zero;</li>
	<li>“<code>C</code> c” — sum up all values in column c, print the result and set all values in column c to zero.</li>
</ul>

<p>They have predicted what queries and results there will be. They need to ensure that they have correctly predicted the results. Help them by computing the results of the queries.</p>

### 입력 

 <p>The first line of the input contains two integers n and q (1 ≤ n ≤ 10<sup>6</sup> , 1 ≤ q ≤ 10<sup>5</sup> ) — the size of the square and the number of queries.</p>

<p>Each of the next q lines contains the description of the query. Each query is either “<code>R</code> r” (1 ≤ r ≤ n) or “<code>C</code> c” (1 ≤ c ≤ n).</p>

### 출력 

 <p>The output file shall contain q lines. The i-th line shall contain one integer — the result of the i-th query.</p>

