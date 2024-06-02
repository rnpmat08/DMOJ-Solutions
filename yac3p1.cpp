#include <iostream>

using namespace std;

pair<int, int> S[1000000];

int main() {
    int N, M, A, B, E = 0; cin >> N >> M >> A >> B;
    for (int i = 0; i < M; i++) {
        int x, y = -1; cin >> x;
        if (x != -1) {
            cin >> y;
        } else {
            E++;
        }
        S[i] = {x, y};
    }
    for (int i = 0; i < M; i++) {
        if (E == 1) break;
        if (S[i].first == -1 && S[i].second == -1) {
            E--;
            S[i] = {1, 2};
        }
    }
    int X = A;
    for (int i = 0; i < M; i++) {
        if (S[i].first == X) {
            X = S[i].second;
        } else if (S[i].second == X) {
            X = S[i].first;
        }
        if (S[i].first == -1) break;
    }
    int Y = B;
    for (int i = M - 1; i >= 0; i--) {
        if (S[i].first == Y) {
            Y = S[i].second;
        } else if (S[i].second == Y) {
            Y = S[i].first;
        }
        if (S[i].first == -1) break;
    }
    int idx;
    for (int i = 0; i < M; i++) {
        if (S[i].first == -1) {
            idx = i;
            break;
        }
    }
    if (X != Y) {
        S[idx] = {X, Y};
    } else {
        if (X == 1) {
            S[idx] = {2, 3};
        } else if (X == 2) {
            S[idx] = {1, 3};
        } else {
            S[idx] = {1, 2};
        }
    }
    for (int i = 0; i < M; i++) cout << S[i].first << " " << S[i].second << "\n";
    return 0;
}