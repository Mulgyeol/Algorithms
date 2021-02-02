def max_sum(A, left, right):
	# A[left], ..., A[right] 중 최대 구간 합 리턴
	
    if left == right or left > right:
        return A[left]
	
    m = (left+right)//2
		
    left_sum = 0
    right_sum = 0
    left_list = []
    right_list = []
    
    for i in range(m,left-1,-1):
        left_sum += A[i]
        left_list.append(left_sum)
    
    max_left = max(left_list)

    for i in range(m+1,right+1):
        right_sum += A[i]
        right_list.append(right_sum)

    max_right = max(right_list)

    middle = max_left + max_right

    detail = max(max_sum(A,left,m),max_sum(A,m+1,right))

    return max(detail,middle)
	
    
	

A = [int(x) for x in input().split()]
sol = max_sum(A, 0, len(A)-1)
print(sol)
