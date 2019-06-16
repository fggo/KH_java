if has("gui_running")
  if has("gui_gtk2")
    set guifont=Inconsolata\ 12
  elseif has("gui_macvim")
    set guifont=Menlo\ Regular:h14
  elseif has("gui_win32")
    set guifont=Consolas:h10:cANSI
  endif
endif

syntax on
set background=dark
colorscheme darth

set lines=55 columns=90

winpos 610 150

set backspace=indent,eol,start

set nu

set tabstop=4
set shiftwidth=4
set expandtab