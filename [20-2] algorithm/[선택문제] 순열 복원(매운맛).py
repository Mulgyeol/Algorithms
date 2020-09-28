def reconstruct(B):
    A = [0 for x in range(len(B))]
    for i in range(1, len(B)):
        if B[i] == 0:
            for j in range(0, i):
                A[j] = A[j] + 1
        else:
            if B[i] == i:
                A[i] = A[i] + i
            else:
                for x in range(0, i):
                    if A[x] >= B[i]:
                        A[x] = A[x] + 1
                A[i] = B[i]
    return A

B = [int(x) for x in input().split()]
A = reconstruct(B)
print(A)