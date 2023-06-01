# Ready Set Exam API
## Getting Started
The API's main purpose is to provide users with a full exam preparation schedule by calculating their free time. Additionally, it includes a built-in functionality to identify if a provided date falls under "special dates."

## Installation
Clone repository https://github.com/Edvinas11/readysetexam.git

## Usage
1. Run Java code
2. Open Postman
3. Make HTTP request to the provided endpoint
Endpoint: `localhost:8080/calculateschedule`
Method: POST

### Request Payload:
To effectively utilize the API, you need to provide the examDate and the available free hours for exam preparation each day leading up to the final exam. Please ensure you include all the days from the current date until the exam date. Here's an example:

```json
{
  "examDate": "2023-06-15",
  "dailyAvailability": [
    {
      "date": "2023-05-30",
      "freeHours": 4
    },
    {
      "date": "2023-05-31",
      "freeHours": 5
    },
    {
      "date": "2023-06-01",
      "freeHours": 6
    },
    {
      "date": "2023-06-02",
      "freeHours": 4
    },
    {
      "date": "2023-06-03",
      "freeHours": 5
    },
    // Continue adding daily availability objects for each day until the exam date
  ]
}
```
#### Example 1.
```json
{
  "examDate": "2023-06-01",
  "dailyAvailability": [
    {
      "date": "2023-05-30",
      "freeHours": 5
    },
    {
      "date": "2023-05-31",
      "freeHours": 3
    }
  ]
}
```

### Response:
```json
{
    "examDate": "2023-06-01",
    "totalPreparationTime": 8,
    "dailyPreparation": [
        {
            "date": "2023-05-30",
            "preparationTime": 4
        },
        {
            "date": "2023-05-31",
            "preparationTime": 2
        },
        {
            "date": "2023-06-01",
            "preparationTime": 2
        }
    ]
}
```

#### Important Note:
If you notice that the preparation time calculated for a specific date is set to 0, there's no need to worry. This indicates that the date falls under a special event or holiday when you may not have any available free hours for exam preparation.

During such special events, it's crucial to prioritize the event and adjust your study schedule accordingly. Use this time to relax, enjoy the event, or engage in other activities. Remember, taking breaks and maintaining a healthy work-life balance is essential for effective exam preparation.

### Credits
Edvinas Burba, 2023