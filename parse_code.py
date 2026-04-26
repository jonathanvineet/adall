import re
import os

with open('/Users/jonathan/elco/adall/raw_prompt.txt', 'r') as f:
    lines = f.readlines()

# Remove line numbers from the beginning of each line
cleaned_lines = []
for line in lines:
    # Match an optional space, one or more digits, space, and the rest of the line
    match = re.match(r'^\s*\d+\s?(.*)', line)
    if match:
        cleaned_lines.append(match.group(1))
    else:
        # If the line doesn't match the format (e.g., empty line without line number), keep it as is
        # Actually in the prompt all lines have line numbers, even empty ones.
        # But let's be safe.
        if re.match(r'^\s*\d+$', line):
            cleaned_lines.append('\n')
        else:
            cleaned_lines.append(line)

content = '\n'.join(cleaned_lines)

# Split by programs
# Look for headers like:
# ================================================================
# 1. BOOKSTORE STUDENT REGISTRATION
# ================================================================

programs = re.split(r'={50,}\n\s*\d+\.\s*(.*?)\n={50,}', content)

if len(programs) > 1:
    with open('README.md', 'w') as f:
        f.write("# Android Studio Programs\n\n")
        # programs[0] is everything before the first program header
        for i in range(1, len(programs), 2):
            title = programs[i].strip()
            code = programs[i+1].strip()
            
            # Stop if it's the "END OF ALL PROGRAMS" section
            if "END OF ALL PROGRAMS" in title:
                break
                
            f.write(f"## {i//2 + 1}. {title}\n\n")
            
            # Now split by files within the program
            # e.g., --- activity_main.xml ---
            files = re.split(r'---\s*(.*?)\s*---', code)
            
            if len(files) > 1:
                # files[0] might be empty space before the first file
                for j in range(1, len(files), 2):
                    filename = files[j].strip()
                    file_content = files[j+1].strip()
                    
                    # determine language for markdown
                    lang = ""
                    if filename.endswith('.xml'):
                        lang = "xml"
                    elif filename.endswith('.java'):
                        lang = "java"
                    
                    f.write(f"### `{filename}`\n\n")
                    f.write(f"```{lang}\n{file_content}\n```\n\n")
            else:
                # Fallback if no specific file separators are found
                f.write(f"```text\n{code}\n```\n\n")

print("Parsing complete.")
