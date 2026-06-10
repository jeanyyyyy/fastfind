# fastfind
A 'find' wrapper for Unix based systems. The goal of this project is to make the syntax easier and faster to type.

Note that this is a beginner project, so things may not work as intended.

### Why?
The default 'find' command is quite hard to remember, especially when trying to search for many parameters at once. This tool aims to simplify the usage of 'find'.

---

### Installation:
```bash
git clone https://github.com/jeanyyyyy/fastfind
cd fastfind
bash install.sh
```

### Current features:
Filter search for: 
* image files (.jpg, .png, .gif, .webp)
* video files (.mp4, .avi, .mkv)
* document files (.pdf, .docx, .txt, .odt, .pptx, .odp)
* compressed files (.zip, .rar, .7z)
* installer files (.exe, .tar.gz, .msi, .AppImage, .dmg)

### Usage:
fastfind [flag(s)] [directory] [query]

### Examples:
Search for images containing "xyz" in '~/Downloads/' :
```bash
fastfind -img ~/Downloads/ xyz
```

Search for *all* documents within '~/Documents/' :
```bash
fastfind -doc ~/Documents/
```

Search for all images as well as documents within '~/Desktop/':
```bash
fastfind -doc -img ~/Desktop/
```

---

#### Planned:
* Windows support
* More search options

---

*Feedback is highly appreciated :>*

