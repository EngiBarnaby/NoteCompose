package com.example.noteapp

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noteapp.data.NotesDataSource
import com.example.noteapp.model.Note
import com.example.noteapp.screen.NoteScreen
import com.example.noteapp.screen.NoteViewModel
import com.example.noteapp.ui.theme.NoteAppTheme

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    val noteViewModel : NoteViewModel by viewModels()

                    NotesApp(noteViewModel = noteViewModel)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalComposeUiApi
@Composable
fun NotesApp(noteViewModel: NoteViewModel = viewModel()){

    val noteList = noteViewModel.getAllNotes()

    NoteScreen(
        notes = noteList,
        onRemoveNote = { noteViewModel.removeNote(it) },
        onAddNote = { noteViewModel.addNote(it) },
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoteAppTheme {

    }
}