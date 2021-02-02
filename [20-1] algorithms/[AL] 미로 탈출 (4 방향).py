def find_way_from_maze(r, c):
    # 여기에 길찾기 함수 코드 작성
	visited[r][c] = True
	if r == ey and c == ex:
		return True
	
	if M[r][c+1] == '0' and visited[r][c+1] == False:
		if find_way_from_maze(r, c+1):
			M[r][c+1] = trace
			return True
		
	if M[r+1][c] == '0' and visited[r+1][c] == False:
		if find_way_from_maze(r+1, c):
			M[r+1][c] = trace
			return True
	
	if M[r][c-1] == '0' and visited[r][c-1] == False:
		if find_way_from_maze(r, c-1):
			M[r][c-1] = trace
			return True

	if M[r-1][c] == '0' and visited[r-1][c] == False:
		if find_way_from_maze(r-1, c):
			M[r-1][c] = trace
			return True
	
	return False


trace = '\u00B7'
n = int(input())
sx, sy, ex, ey = (int(x) for x in input().split())
M = []
# row 0 and n+1 are all 1's
# col 0 and n+1 are all 1's
for i in range(n):
    M.append([c for c in input()])

visited = [[False for _ in range(n)] for _ in range(n)]
M[sx][sy] = 's'
success = find_way_from_maze(sx, sy)
M[ex][ey] = 'e'

if success:
    for row in M:
        for c in row:
            if c == '1': 
                print('#', end="")
            elif c == '0':
                print(' ', end="")
            else:
                print(c, end="")
        print()
    print()
else:
    print("NO WAY!")
