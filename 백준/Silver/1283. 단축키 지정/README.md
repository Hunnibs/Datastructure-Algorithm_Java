# [Silver I] 단축키 지정 - 1283 

[문제 링크](https://www.acmicpc.net/problem/1283) 

### 성능 요약

메모리: 11572 KB, 시간: 68 ms

### 분류

구현, 문자열

### 제출 일자

2024년 11월 27일 10:04:30

### 문제 설명

<p>The menu in a computer program contains N options. Each option is described by one or more words. </p>

<p>Each option in the menu, in order from first to last, is assigned a shortcut – one of the letters in its description. The rules for assigning the shortcut are: </p>

<ul>
	<li>First consider the initial letters of all words in the description, in order from first to last. The first such initial letter not already to another option is selected (no two options may have the same shortcut). </li>
	<li>If all initial letters are already assigned, then consider all remaining letters in the description in order, again choosing the first available letter. </li>
	<li>If none of the letters in the description are available, then the option has no shortcut. </li>
	<li>The process is not case sensitive; lowercase and uppercase letters are considered the same. </li>
</ul>

<p>Write a program which, given the descriptions of all options, determines the shortcuts. </p>

### 입력 

 <p>The first line contains the integer N (1 ≤ N ≤ 30), the number of options in the menu. </p>

<p>Each of the following N lines contains the description of one option, a sequence of at most 5 words separated by single spaces. Each word will contain at most 10 letters of the English alphabet. </p>

### 출력 

 <p>For each option, in the same order in which they were given, output its description with the shortcut letter surrounded by brackets. If an option is not assigned a shortcut, output its description unchanged. </p>

<p>The case of all letters must be the same as in the input.</p>

