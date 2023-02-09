# MatKor - 오락고

i, day, countK = 0, 0, 0;
n, k = map(int, input().split());

while True:
	day += 1;
	i += 1;
	if str(k) in str(i):
		countK +=1;
		if countK==n:
			break;

print(day);

# 일단 GG