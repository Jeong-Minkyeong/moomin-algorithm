def solution(lines):
    overlaps = []  # 겹치는 부분을 저장할 리스트
    for i in range(len(lines)):
        for j in range(i+1, len(lines)):
            if lines[i][1] >= lines[j][0] and lines[i][0] <= lines[j][1]:
                # 두 선분이 겹치는 경우
                overlap_start = max(lines[i][0], lines[j][0])
                overlap_end = min(lines[i][1], lines[j][1])
                overlap_length = overlap_end - overlap_start

                # 중복 계산 방지 및 중첩되는 부분 제거
                for start, end in overlaps:
                    if overlap_start <= end and overlap_end >= start:
                        overlap_start = min(overlap_start, start)
                        overlap_end = max(overlap_end, end)
                        overlap_length = overlap_end - overlap_start
                        overlaps.remove((start, end))

                overlaps.append((overlap_start, overlap_end))

    # 겹치는 부분들의 길이 합산
    total_length = sum([end - start for start, end in overlaps])

    return total_length
                             
# [-2 3] [-1 0] [0 1]
# [[0, 5] [1, 10] [3, 9]]
