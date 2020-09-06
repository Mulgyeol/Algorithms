def quick_sort(A): #not in-place, stable
    if len(A) <= 1:
        return A
    
    p = A[0]
    S,M,L = [],[],[]
    
    for x in A:
        if p>x:
            S.append(x)
        elif p<x:
            L.append(x)
        else:
            M.append(x)
            
    return quick_sort(S)+M+quick_sort(L)


def quick_sort(A, first, last): #in-place // 전체 하는 법 quick_sort(A,0,len(A)-1)
    if first >= last:
        return A
    p = A[first]
    left = first + 1
    right = last

    while left <= right:
        while left<=last and A[left]<p:
            left += 1
        while A[right]>p:
            right -= 1
        if left <= right:
            A[left],A[right] = A[right],A[left]
            left += 1
            right -= 1
    A[first],A[right] = A[right],A[first]

    return quick_sort(A,first,right-1)+quick_sort(A,left,last)
