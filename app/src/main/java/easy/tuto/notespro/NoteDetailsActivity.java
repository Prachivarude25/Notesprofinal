
/*package easy.tuto.notespro;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class NoteDetailsActivity extends AppCompatActivity {

    EditText titleEditText, contentEditText;
    ImageButton saveNoteBtn;
    TextView pageTitleTextView, deleteNoteTextViewBtn;
    String title, content, docId;
    boolean isEditMode = false;
    Spinner fontSizeSpinner, fontColorSpinner, backgroundColorSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);
        Log.d(TAG, "onCreate: Started");
        titleEditText = findViewById(R.id.notes_title_text);
        contentEditText = findViewById(R.id.notes_content_text);
        saveNoteBtn = findViewById(R.id.save_note_btn);
        pageTitleTextView = findViewById(R.id.page_title);
        deleteNoteTextViewBtn = findViewById(R.id.delete_note_text_view_btn);
        contentEditText = findViewById(R.id.notes_content_text);
        fontSizeSpinner = findViewById(R.id.font_size_spinner);
        fontColorSpinner = findViewById(R.id.font_color_spinner);
        backgroundColorSpinner = findViewById(R.id.background_color_spinner);

        setupFontSizeSpinner();
        setupFontColorSpinner();
        setupBackgroundColorSpinner();

        title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("content");
        docId = getIntent().getStringExtra("docId");

        if (docId != null) {
            isEditMode = true;
        }

        titleEditText.setText(title);
        contentEditText.setText(content);

        if (isEditMode) {
            pageTitleTextView.setText("Edit your note");
            deleteNoteTextViewBtn.setVisibility(View.VISIBLE);
        }

        saveNoteBtn.setOnClickListener(v -> saveNote());
        deleteNoteTextViewBtn.setOnClickListener(v -> deleteNoteFromFirebase());
    }

    void saveNote() {
        String noteTitle = titleEditText.getText().toString();
        String noteContent = contentEditText.getText().toString();

        if (noteTitle.isEmpty()) {
            titleEditText.setError("Title is required");
            return;
        }

        Note note = new Note();
        note.setTitle(noteTitle);
        note.setContent(noteContent);
        note.setTimestamp(Timestamp.now());

        saveNoteToFirebase(note);
    }

    void saveNoteToFirebase(Note note) {
        DocumentReference documentReference;

        if (isEditMode) {
            documentReference = Utility.getCollectionReferenceForNotes().document(docId);
        } else {
            documentReference = Utility.getCollectionReferenceForNotes().document();
        }

        documentReference.set(note).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Utility.showToast(NoteDetailsActivity.this, "Note " + (isEditMode ? "updated" : "added") + " successfully");
                finish();
            } else {
                Utility.showToast(NoteDetailsActivity.this, "Failed while " + (isEditMode ? "updating" : "adding") + " note");
            }
        });
    }

    void deleteNoteFromFirebase() {
        if (isEditMode) {
            Utility.getCollectionReferenceForNotes().document(docId).delete().addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Utility.showToast(NoteDetailsActivity.this, "Note deleted successfully");
                    finish();
                } else {
                    Utility.showToast(NoteDetailsActivity.this, "Failed while deleting note");
                }
            });
        }
    }
    private void setupFontSizeSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.font_size_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fontSizeSpinner.setAdapter(adapter);
        fontSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedFontSize = (String) parent.getItemAtPosition(position);
                float fontSize = Float.parseFloat(selectedFontSize);
                contentEditText.setTextSize(fontSize);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    private void setupFontColorSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.font_color_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fontColorSpinner.setAdapter(adapter);
        fontColorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedFontColor = (String) parent.getItemAtPosition(position);
                int fontColor = Color.parseColor(selectedFontColor);
                contentEditText.setTextColor(fontColor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    private void setupBackgroundColorSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.background_color_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        backgroundColorSpinner.setAdapter(adapter);
        backgroundColorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedBackgroundColor = (String) parent.getItemAtPosition(position);
                int backgroundColor = Color.parseColor(selectedBackgroundColor);
                contentEditText.setBackgroundColor(backgroundColor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }
}*/
/*package easy.tuto.notespro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class NoteDetailsActivity extends AppCompatActivity {

    EditText titleEditText, contentEditText;
    ImageButton saveNoteBtn;
    TextView pageTitleTextView, deleteNoteTextViewBtn;
    String title, content, docId;
    boolean isEditMode = false;
    Button fontColorButton, backgroundColorButton;
    Spinner fontSizeSpinner, fontColorSpinner, backgroundColorSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

        fontColorButton = findViewById(R.id.font_color_button);
        backgroundColorButton = findViewById(R.id.background_color_button);
        titleEditText = findViewById(R.id.notes_title_text);
        contentEditText = findViewById(R.id.notes_content_text);
        saveNoteBtn = findViewById(R.id.save_note_btn);
        pageTitleTextView = findViewById(R.id.page_title);
        deleteNoteTextViewBtn = findViewById(R.id.delete_note_text_view_btn);
        fontSizeSpinner = findViewById(R.id.font_size_spinner);
        fontColorSpinner = findViewById(R.id.font_color_spinner);
        backgroundColorSpinner = findViewById(R.id.background_color_spinner);

        setupFontSizeSpinner();
        setupFontColorSpinner();
        setupBackgroundColorSpinner();

        title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("content");
        docId = getIntent().getStringExtra("docId");

        if (docId != null) {
            isEditMode = true;
        }

        titleEditText.setText(title);
        contentEditText.setText(content);

        if (isEditMode) {
            pageTitleTextView.setText("Edit your note");
            deleteNoteTextViewBtn.setVisibility(View.VISIBLE);
        }

        saveNoteBtn.setOnClickListener(v -> saveNote());
        deleteNoteTextViewBtn.setOnClickListener(v -> deleteNoteFromFirebase());
    }

    void saveNote() {
        String noteTitle = titleEditText.getText().toString();
        String noteContent = contentEditText.getText().toString();

        if (noteTitle.isEmpty()) {
            titleEditText.setError("Title is required");
            return;
        }

        Note note = new Note();
        note.setTitle(noteTitle);
        note.setContent(noteContent);
        note.setTimestamp(Timestamp.now());

        saveNoteToFirebase(note);
    }

    void saveNoteToFirebase(Note note) {
        DocumentReference documentReference;

        if (isEditMode) {
            documentReference = Utility.getCollectionReferenceForNotes().document(docId);
        } else {
            documentReference = Utility.getCollectionReferenceForNotes().document();
        }

        documentReference.set(note).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Utility.showToast(NoteDetailsActivity.this, "Note " + (isEditMode ? "updated" : "added") + " successfully");
                finish();
            } else {
                Utility.showToast(NoteDetailsActivity.this, "Failed while " + (isEditMode ? "updating" : "adding") + " note");
            }
        });
    }

    void deleteNoteFromFirebase() {
        if (isEditMode) {
            Utility.getCollectionReferenceForNotes().document(docId).delete().addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Utility.showToast(NoteDetailsActivity.this, "Note deleted successfully");
                    finish();
                } else {
                    Utility.showToast(NoteDetailsActivity.this, "Failed while deleting note");
                }
            });
        }
    }

    private void setupFontSizeSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.font_size_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fontSizeSpinner.setAdapter(adapter);
        fontSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedFontSize = (String) parent.getItemAtPosition(position);
                float fontSize = Float.parseFloat(selectedFontSize);
                contentEditText.setTextSize(fontSize);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    private void setupFontColorSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.font_color_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fontColorSpinner.setAdapter(adapter);
        fontColorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedFontColor = (String) parent.getItemAtPosition(position);
                int fontColor = Color.parseColor(selectedFontColor);
                contentEditText.setTextColor(fontColor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    private void setupBackgroundColorSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.background_color_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        backgroundColorSpinner.setAdapter(adapter);
        backgroundColorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedBackgroundColor = (String) parent.getItemAtPosition(position);
                int backgroundColor = Color.parseColor(selectedBackgroundColor);
                contentEditText.setBackgroundColor(backgroundColor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });


}
}*/
package easy.tuto.notespro;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class NoteDetailsActivity extends AppCompatActivity {

    EditText titleEditText, contentEditText;
    Button fontColorButton, backgroundColorButton;
    Spinner fontSizeSpinner, fontColorSpinner, backgroundColorSpinner;
    TextView pageTitleTextView, deleteNoteTextViewBtn;
    ImageButton saveNoteBtn;
    String title, content, docId;
    boolean isEditMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

        titleEditText = findViewById(R.id.notes_title_text);
        contentEditText = findViewById(R.id.notes_content_text);
        saveNoteBtn = findViewById(R.id.save_note_btn);
        pageTitleTextView = findViewById(R.id.page_title);
        deleteNoteTextViewBtn = findViewById(R.id.delete_note_text_view_btn);
        fontSizeSpinner = findViewById(R.id.font_size_spinner);
        fontColorSpinner = findViewById(R.id.font_color_spinner);
        backgroundColorSpinner = findViewById(R.id.background_color_spinner);
        fontColorButton = findViewById(R.id.font_color_button);
        backgroundColorButton = findViewById(R.id.background_color_button);

        setupFontSizeSpinner();
        setupFontColorSpinner();
        setupBackgroundColorSpinner();

        title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("content");
        docId = getIntent().getStringExtra("docId");

        if (docId != null) {
            isEditMode = true;
        }

        titleEditText.setText(title);
        contentEditText.setText(content);

        if (isEditMode) {
            pageTitleTextView.setText("Edit your note");
            deleteNoteTextViewBtn.setVisibility(View.VISIBLE);
        }

        saveNoteBtn.setOnClickListener(v -> saveNote());
        deleteNoteTextViewBtn.setOnClickListener(v -> deleteNoteFromFirebase());

        fontColorButton.setOnClickListener(v -> showColorPickerDialog(true));
        backgroundColorButton.setOnClickListener(v -> showColorPickerDialog(false));
    }

    void saveNote() {
        String noteTitle = titleEditText.getText().toString();
        String noteContent = contentEditText.getText().toString();

        if (noteTitle.isEmpty()) {
            titleEditText.setError("Title is required");
            return;
        }

        Note note = new Note();
        note.setTitle(noteTitle);
        note.setContent(noteContent);
        note.setTimestamp( Timestamp.now());

        saveNoteToFirebase(note);
    }

    void saveNoteToFirebase(Note note) {
        DocumentReference documentReference;

        if (isEditMode) {
            documentReference = Utility.getCollectionReferenceForNotes().document(docId);
        } else {
            documentReference = Utility.getCollectionReferenceForNotes().document();
        }

        documentReference.set(note).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Utility.showToast(NoteDetailsActivity.this, "Note " + (isEditMode ? "updated" : "added") + " successfully");
                finish();
            } else {
                Utility.showToast(NoteDetailsActivity.this, "Failed while " + (isEditMode ? "updating" : "adding") + " note");
            }
        });
    }

    void deleteNoteFromFirebase() {
        if (isEditMode) {
            Utility.getCollectionReferenceForNotes().document(docId).delete().addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Utility.showToast(NoteDetailsActivity.this, "Note deleted successfully");
                    finish();
                } else {
                    Utility.showToast(NoteDetailsActivity.this, "Failed while deleting note");
                }
            });
        }
    }

    private void setupFontSizeSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.font_size_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fontSizeSpinner.setAdapter(adapter);

        fontSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedFontSize = (String) parent.getItemAtPosition(position);
                float fontSize = Float.parseFloat(selectedFontSize);
                contentEditText.setTextSize(fontSize);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    private void setupFontColorSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.font_color_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fontColorSpinner.setAdapter(adapter);

        fontColorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedFontColor = (String) parent.getItemAtPosition(position);
                int fontColor = Color.parseColor(selectedFontColor);
                contentEditText.setTextColor(fontColor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    private void setupBackgroundColorSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.background_color_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        backgroundColorSpinner.setAdapter(adapter);
        backgroundColorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedBackgroundColor = (String) parent.getItemAtPosition(position);
                int backgroundColor = Color.parseColor(selectedBackgroundColor);
                contentEditText.setBackgroundColor(backgroundColor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    private void showColorPickerDialog(final boolean isFontColor) {
        AlertDialog.Builder colorPickerDialog = new AlertDialog.Builder(this);
        colorPickerDialog.setTitle("Choose Color");

        // Set up the color picker dialog with predefined colors
        final String[] colors = getResources().getStringArray(R.array.font_color_options);
        colorPickerDialog.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String selectedColor = colors[which];
                int color = Color.parseColor(selectedColor);
                if (isFontColor) {
                    contentEditText.setTextColor(color);
                } else {
                    contentEditText.setBackgroundColor(color);
                }
            }
        });

        // Add cancel button
        colorPickerDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // Show dialog
        colorPickerDialog.show();
    }
}

