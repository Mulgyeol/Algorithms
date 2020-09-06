def bigger(x,y):
	if x>y:
		return x
	else:
		return y

def max2(A, left, right):
	if left == right:
		return A[left]
	return bigger(max2(A,left,(right+left)//2) , max2(A,(right+left)//2+1,right))

# n개의 정수를 읽어 A에 저장
A = list(map(int,input().split()))
print(max2(A, 0, len(A)-1))


##인덱스만 변함
