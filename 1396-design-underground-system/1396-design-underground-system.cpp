class UndergroundSystem {
private:
    // id -> {check-in station, check-in time}
    unordered_map<int, pair<string, int>> checkIns;

    // "start#end" -> {total travel time, number of trips}
    unordered_map<string, pair<long long, int>> trips;

public:
    UndergroundSystem() {
    }

    void checkIn(int id, string stationName, int t) {
        checkIns[id] = {stationName, t};
    }

    void checkOut(int id, string stationName, int t) {
        auto [startStation, startTime] = checkIns[id];

        int travelTime = t - startTime;

        string route = startStation + "#" + stationName;

        trips[route].first += travelTime;
        trips[route].second++;

        checkIns.erase(id);
    }

    double getAverageTime(string startStation, string endStation) {
        string route = startStation + "#" + endStation;

        auto [totalTime, count] = trips[route];

        return (double)totalTime / count;
    }
};


/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem* obj = new UndergroundSystem();
 * obj->checkIn(id,stationName,t);
 * obj->checkOut(id,stationName,t);
 * double param_3 = obj->getAverageTime(startStation,endStation);
 */