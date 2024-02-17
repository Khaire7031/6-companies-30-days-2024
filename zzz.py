

from codecarbon import OfflineEmissionsTracker

tracker = OfflineEmissionsTracker(country_iso_code="IND")

tracker.start()
sum = 0
for i in range(100):
    sum = sum + 1

print(sum)
tracker.stop()
