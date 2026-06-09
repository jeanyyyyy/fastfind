#!/usr/bin/env bash
set -euo pipefail

NAME="fastfind"
INSTALL_DIR="$HOME/.local/bin"
LIB_DIR="$HOME/.local/lib/$NAME"

mkdir -p "$INSTALL_DIR" "$LIB_DIR"
REPO_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cp "$REPO_DIR/lib/$NAME.jar" "$LIB_DIR/$NAME.jar"
cat > "$INSTALL_DIR/$NAME" << EOF
#!/usr/bin/env bash
exec java -jar "$LIB_DIR/$NAME.jar" "\$@"
EOF

chmod +x "$INSTALL_DIR/$NAME"

if [[ ":$PATH:" != *":$INSTALL_DIR:"* ]]; then
  echo 'export PATH="$HOME/.local/bin:$PATH"' >> ~/.bashrc
  echo "Type: source ~/.bashrc in your terminal."
fi


echo "$NAME was successfully installed."
echo "Usage: fastfind [filter] [directory] [query]"
