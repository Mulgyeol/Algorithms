def two_max(A, left, right):
    if left == right:
        return A[left], None

    mid = (right+left)//2
   
    L1, L2 = two_max(A,left,mid)
    R1, R2 = two_max(A,mid+1, right)

    m = M = -float('inf') 
    for n in L1,L2,R1,R2:
        if n == None:
            n = -float('inf')
        if n >= M:
            m = M
            M = n
        elif m < n < M:
            m = n
        
    return M, m

# n개의 정수를 읽어 A에 저장
A = list(map(int,input().split()))
print(two_max(A, 0, len(A)-1))
