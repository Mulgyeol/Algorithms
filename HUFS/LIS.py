def print_IS(seq, x):
    for i in range(len(seq)):
        if x[i]: 
            print(seq[i], end="")
        else:
            print("_", end="")
    print()

def LIS_DP(seq):
	x = [0] * len(seq)
	DP = [0] * len(seq)
	
	for i in range(0,len(seq)):
		DP[i] = 1
		a = [0] * len(seq)
		for j in range(i):
			if seq[i] > seq[j]:
				DP[i] = max(DP[i],DP[j]+1)
				if seq[j] not in a:
					a[j] = seq[j]
					
		a[i] = seq[i]
		if x.count(0) > a.count(0):
			x = a

	lis = max(DP)
	
	return lis, x
		
	
    # code here

seq = input()  # 알파벳 소문자로만 구성된 string 하나가 입력된다
lis, x = LIS_DP(seq)
print(lis)
