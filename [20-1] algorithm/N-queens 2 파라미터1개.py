#Nqueens(k): # X[k]를 결정
#    if k >= N: #x[0]…x[N-1]까지 결정했음.
#        return
#    for c in range(N):
#	If queen can place at(k,c) : #같은 열 같은 대각선에 충돌이 있는지.
#	    X[k] = c
#	    Nqueens(k+1)


def Nqueens(k):
    if len(X) >= k:
        print(X)
        return 0
    candidate = list(range(k)) # 0부터 n-1까지를 후보 배열로 만든다.
    for i in range(len(X)):
        if X[i] in candidate: # 같은 열에 있는 지 확인
            candidate.remove(X[i]) # 같은 열에 있다면 후보에서 제외
        distance = len(X) - i
        if X[i] + distance in candidate: # 같은 대각성 상(+)에 있는 지 확인
            candidate.remove(X[i] + distance) # 같은 대각선 상에 있다면 후보에서 제외
        if X[i] - distance in candidate: # 같은 대각선 상(-)에 있는 지 확인
            candidate.remove(X[i] - distance) # 같은 대각선 상에 있다면 후보에서 제외
    if candidate != []:
        for i in candidate:
            X.append(i) # 후보의 요소를 정답 배열의 i+1로 추가
            Nqueens(k) # 재귀적으로 다음 행도 확인
            X.pop()
    else:
        return 0
    
count = 0
num = int(input())
for i in range(num): # 첫 행의 경우의 수
    X = [i]
    Nqueens(num)


