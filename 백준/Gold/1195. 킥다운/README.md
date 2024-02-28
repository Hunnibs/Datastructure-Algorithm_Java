# [Gold V] 킥다운 - 1195 

[문제 링크](https://www.acmicpc.net/problem/1195) 

### 성능 요약

메모리: 11644 KB, 시간: 80 ms

### 분류

브루트포스 알고리즘, 구현

### 제출 일자

2024년 2월 19일 21:22:56

### 문제 설명

<p>A research laboratory of a world-leading automobile company has received an order to create a special transmission mechanism, which allows for incredibly eﬃcient kickdown — an operation of switching to lower gear. After several months of research engineers found that the most eﬃcient solution requires special gears with teeth and cavities placed non-uniformly. They calculated the optimal ﬂanks of the gears. Now they want to perform some experiments to prove their ﬁndings.</p>

<p>The ﬁrst phase of the experiment is done with planar toothed sections, not round-shaped gears. A section of length n consists of n units. The unit is either a cavity of height h or a tooth of height 2h. Two sections are required for the experiment: one to emulate master gear (with teeth at the bottom) and one for the driven gear (with teeth at the top).</p>

<p><img alt="" src="https://www.acmicpc.net/upload/images/kick1.png" style="height:105px; width:449px"></p>

<p>There is a long stripe of width 3h in the laboratory and its length is enough for cutting two engaged sections together. The sections are irregular but they may still be put together if shifted along each other.</p>

<p><img alt="" src="https://www.acmicpc.net/upload/images/kick2.png" style="height:78px; width:442px"></p>

<p>The stripe is made of an expensive alloy, so the engineers want to use as little of it as possible. You need to ﬁnd the minimal length of the stripe which is enough for cutting both sections simultaneously.</p>

### 입력 

 <p>There are two lines in the input ﬁle, each contains a string to describe a section. The ﬁrst line describes master section (teeth at the bottom) and the second line describes driven section (teeth at the top). Each character in a string represents one section unit — 1 for a cavity and 2 for a tooth. The sections can not be ﬂipped or rotated.</p>

<p>Each string is non-empty and its length does not exceed 100.</p>

### 출력 

 <p>Write a single integer number to the output ﬁle — the minimal length of the stripe required to cut oﬀ given sections.</p>

