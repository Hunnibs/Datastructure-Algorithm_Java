# [Gold IV] 왕위 계승 - 5021 

[문제 링크](https://www.acmicpc.net/problem/5021) 

### 성능 요약

메모리: 11888 KB, 시간: 72 ms

### 분류

방향 비순환 그래프, 자료 구조, 그래프 이론, 그래프 탐색, 해시를 사용한 집합과 맵, 위상 정렬

### 제출 일자

2024년 12월 7일 13:30:50

### 문제 설명

<p>The king in Utopia has died without an heir. Now several nobles in the country claim the throne. The country law states that if the ruler has no heir, the person who is most related to the founder of the country should rule.</p>

<p>To determine who is most related we measure the amount of blood in the veins of a claimant that comes from the founder. A person gets half the blood from the father and the other half from the mother. A child to the founder would have 1/2 royal blood, that child's child with another parent who is not of royal lineage would have 1/4 royal blood, and so on. The person with most blood from the founder is the one most related.</p>

### 입력 

 <p>The first line contains two integers, N (2 ≤ N ≤ 50) and M (2 ≤ M ≤ 50).</p>

<p>The second line contains the name of the founder of Utopia.</p>

<p>Then follows N lines describing a family relation. Each such line contains three names, separated with a single space. The first name is a child and the remaining two names are the parents of the child.</p>

<p>Then follows M lines containing the names of those who claims the throne.</p>

<p>All names in the input will be between 1 and 10 characters long and only contain the lowercase English letters 'a'-'z'. The founder will not appear among the claimants, nor be described as a child to someone else.</p>

### 출력 

 <p>A single line containing the name of the claimant with most blood from the founder. The input will be constructed so that the answer is unique.</p>

<p>The family relations may not be realistic when considering sex, age etc. However, every child will have two unique parents and no one will be a descendent from themselves. No one will be listed as a child twice.</p>

