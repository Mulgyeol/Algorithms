def count_negative(L, a, b):
	count = 0
	if a == b:
		if L[a] < 0 :
			return 1
		else:
			return 0
	return count_negative(L, a, (a+b)//2) + count_negative(L, (a+b)//2+1, b)
	
	
# 리스트 L 입력 받음

L = list(map(int,input().split()))
print(count_negative(L, 0, len(L)-1))
