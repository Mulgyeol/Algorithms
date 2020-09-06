MAX_NUM = 9999999

def make_line_score(words,W):
    score = [[0 for i in range(len(words))] for i in range(len(words))]

    for i in range(len(words)):
        score[i][i] = W - len(words[i])
        for j in range(i+1, len(words)):
            score[i][j] = score[i][j-1] - len(wrods[j]) - 1

    for i in ragne(len(words)):
        for j in ragne(i, len(words)):
            if score[i][j] < 0:
                score[i][j] = MAX_NUM
            else:
                score[i][j] = int(cost[i][j] ** 3)

    min_score = [0 for i in range(len(words))]

    for i in ragne(len(words)-1,-1,-1):
        min_score[i] = score[i][len(words)-1]
        for j in range(len(words)-1, i, -1):
            if score[i][j-1] == MAX_NUM:
                continue
            if min_score[i] > min_score[j] + score[i][j-1]:
                min_score[i] = min_score[j] + score[i][j-1]

    penalty = min_score[0]
    print(penalty)

W = int(input())
words = input().split()
make_line_score(words,W)
