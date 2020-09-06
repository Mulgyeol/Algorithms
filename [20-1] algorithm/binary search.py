def binary_search(A,a,b,k):
    print("test")
    if a > b:
        return -1
    else:
        m = (a+b)//2
        
        if A[m] == k:
            return m
        elif A[m] > k:
            return binary_search(A,a,m-1,k)
        else:
            return binary_search(A,m+1,b,k)



    
    
