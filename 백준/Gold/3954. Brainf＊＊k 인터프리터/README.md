# [Gold I] Brainf**k 인터프리터 - 3954 

[문제 링크](https://www.acmicpc.net/problem/3954) 

### 성능 요약

메모리: 17236 KB, 시간: 3328 ms

### 분류

자료 구조, 구현, 시뮬레이션, 스택

### 제출 일자

2025년 1월 23일 15:56:16

### 문제 설명

<p>Given a brainf**k program, determine whether it terminates or enters an endless loop.</p>

<p>A brainf**k interpreter has a data array (consisting of unsigned 8-bit integers) with an index, the so called "data index"; the entry of the array pointed to by the data index is the so called "current entry". A brainf**k program consists of a sequence of the following eight instructions:</p>

<table class="table table-bordered" style="width:100%">
	<tbody>
		<tr>
			<th style="width:20%">-</th>
			<td style="width:80%">decrease current entry by 1 (modulo 2<sup>8</sup>)</td>
		</tr>
		<tr>
			<th>+</th>
			<td>increase current entry by 1 (modulo 2<sup>8</sup>)</td>
		</tr>
		<tr>
			<th><</th>
			<td>decrease data index by 1</td>
		</tr>
		<tr>
			<th>></th>
			<td>increase data index by 1</td>
		</tr>
		<tr>
			<th>[</th>
			<td>jump behind the matching ], if the current entry is equal to 0</td>
		</tr>
		<tr>
			<th>]</th>
			<td>jump behind the matching [ if the current entry is not equal to 0</td>
		</tr>
		<tr>
			<th>.</th>
			<td>print the current entry as character</td>
		</tr>
		<tr>
			<th>,</th>
			<td>read a character and save it into the current entry. On end of input save 255.</td>
		</tr>
	</tbody>
</table>

<p>Interpretation of a brainf**k program starts at the first instruction, and terminates if the instruction pointer leaves the end of the program. After an instruction is executed, the instruction pointer advances to the instruction to the right (except, of course, if the loop instructions [ or ] cause a jump).</p>

<p>In addition to the program, you will be given the size of the data array. The entries of the data array shall be unsigned 8-bit integers, with usual over- or underflow behaviour. At the start of the</p>

<p>program, the data array entries and the data index shall be initialized to zero. Incrementing or decrementing the data index beyond the boundaries of the data array shall make it re-enter the data array at the other boundary; e.g. decrementing the data index when it is zero shall set it to the size of the data array minus one.</p>

<p>The [ and ] instructions define loops and are allowed to nest. Every given program will be wellformed, i.e. when traversing the program from left to right, the number of [ instructions minus the number of ] instructions will always be greater or equal zero, and at the end of the program it will be equal to zero.</p>

<p>For the purposes of the problem, discard the output of the interpreted program. </p>

### 입력 

 <p>The input starts with a line containing the number of test cases t (0 < t ≤ 20). Each test case consists of three lines. The first line contains three integers s<sub>m</sub>, s<sub>c</sub>, s<sub>i</sub>, describing the size of the memory, the size of the program code and the size of the input (0 < s<sub>m</sub> ≤ 100 000; 0 < s<sub>c</sub>, s<sub>i</sub> < 4 096). The second line contains the brainf**k program code to be executed; it consists of s<sub>c</sub> characters. The third line contains the input of the program, as text (only printable, non-whitespace characters).</p>

<p>Once the program has consumed all available input, the input instruction shall set the current cell to 255.</p>

### 출력 

 <p>For each test case, print one line, containing either "Terminates" or "Loops", depending on whether the program either terminates after a finite number of steps, or enters an endless loop. If the program loops, also print the indices (0-based) of the two [ and the ] symbols in the code array that correspond to the endless loop. You may safely assume that after 50 000 000 instructions, a program either terminated or hangs in an endless loop, which then was executed at least once. During each iteration of the endless loop at most 50 000 000 instructions are executed.</p>

