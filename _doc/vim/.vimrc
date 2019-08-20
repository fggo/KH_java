if has("gui_running")
  if has("gui_gtk2")
    set guifont=Inconsolata\ 14
  elseif has("gui_macvim")
    set guifont=Menlo\ Regular:h14
  elseif has("gui_win32")
    set guifont=Consolas:h10:cANSI
  endif
endif

syntax on
set background=dark
colorscheme solarized8

set lines=55 columns=90

winpos 610 30

set backspace=indent,eol,start

set nu

nnoremap zz :update<CR>

set encoding=utf-8
set fileencoding=utf-8

set tabstop=2
set shiftwidth=2
set expandtab

inoremap jj <esc>