n = int(input())
DP = [1,1,2] #0인 경우 만들 수는 없지만 계산을 위해 1을 넣는다.

if (n<3):
	print(DP[n])
	
else:
	for i in range(2,n):
		count = 2
		result = DP[i]*1 + DP[i-1]*1 #칸이 1만큼, 2만큼 추가될 경우를 추가
		
		while(i-count >= 0): # 3칸 이상 짝수/홀수칸 늘어날 때 각각 2개씩 추가로 생성되는 것이 있다.
			result += DP[i-count]*2
			count += 1
		
		DP.append(result);
	print(DP[n])
