package com.example.myapplication 

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Navy = Color(0xFF0B2D4D)
private val Green = Color(0xFF32D583)
private val ScreenBackground = Color(0xFFF4F7F9)
private val GreyText = Color(0xFF777777)

// Course data class
data class Course(
    val code: String,
    val title: String,
    val credits: Int,
    val days: String
)

@Composable
fun CourseListScreen() {

    // Seven courses
    val courses = remember {
        listOf(
            Course(
                "CSC 402",
                "Mobile Application Programming",
                3,
                "Sun / Tue"
            ),
            Course(
                "CSC 311",
                "Database Systems",
                4,
                "Sun / Tue"
            ),
            Course(
                "CSC 348",
                "Operating Systems",
                3,
                "Mon / Wed"
            ),
            Course(
                "MATH 202",
                "Discrete Mathematics",
                3,
                "Sun / Thu"
            ),
            Course(
                "ENG 234",
                "Technical Writing",
                2,
                "Tue"
            ),
            Course(
                "PHYS 105",
                "General Physics II",
                4,
                "Sun / Tue"
            ),
            Course(
                "ISLM 101",
                "Islamic Culture",
                2,
                "Thu"
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBackground)
    ) {

        // Top bar
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Navy)
                .padding(16.dp)
        ) {

            Text(
                text = "My Courses",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Task 10 - LazyColumn & data class",
                color = Color.White,
                fontSize = 12.sp
            )
        }

        // Scrolling list
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            items(courses) { course ->
                CourseRow(course)
            }
        }
    }
}

@Composable
fun CourseRow(course: Course) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {

            // Green bar
            Box(
                modifier = Modifier
                    .width(5.dp)
                    .fillMaxHeight()
                    .background(Green)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
            ) {

                // Course information
                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = course.code,
                        color = Navy,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = course.title,
                        color = Navy,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = course.days,
                        color = GreyText,
                        fontSize = 11.sp
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                // Credits chip
                Box(
                    modifier = Modifier
                        .background(
                            color = Green.copy(alpha = 0.15f),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(
                            horizontal = 10.dp,
                            vertical = 5.dp
                        )
                ) {

                    Text(
                        text = "${course.credits} cr",
                        color = Green,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseListScreenPreview() {
    CourseListScreen()
}