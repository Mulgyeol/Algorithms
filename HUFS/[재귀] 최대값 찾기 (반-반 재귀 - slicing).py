def bigger(x,y):
	if x>y:
	    return x
	else:
	    return y

def max2(A):
    if len(A) == 1:
        return A[0]
    return bigger(max2(A[:len(A)//2]) , max2(A[len(A)//2:]))
                                            
            

# n개의 정수를 읽어 A에 저장
A = list(map(int,input().split()))
print(max2(A))

## A[:len(A)//2] 과정이 일종의 copy 연산임. 매번 copy를 해줘야해서 비효율
